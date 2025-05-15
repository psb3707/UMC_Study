package study.spring.umc_5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;
import study.spring.umc_5.domain.Member;
import study.spring.umc_5.domain.Review;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class DataInsert {

    Member member = TestEntityFactory.createTestMember();

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TransactionTemplate tx;

    static final int BULK_INSERT_SIZE = 2000;
    static final int EXECUTE_COUNT = 6000;

    CountDownLatch countDownLatch = new CountDownLatch(EXECUTE_COUNT);


    @DisplayName("")
    @Test
    void initialize() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < EXECUTE_COUNT; i++) {
            executorService.submit(() -> {
                insert();
                countDownLatch.countDown();
                System.out.println("countDownLatch = " + countDownLatch.getCount());
            });

        }

        countDownLatch.await();
        executorService.shutdown();
        if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }

        //given

        //when

        //then
    }

    private void insert() {

        tx.executeWithoutResult(status -> {
            for (int i = 0; i < BULK_INSERT_SIZE; i++ ) {
                Review review = Review.builder()
                        .member(member)
                        .body("review" + i)
                        .score(4.0f)
                        .build();
                em.persist(review);
            }
        });
    }

}
