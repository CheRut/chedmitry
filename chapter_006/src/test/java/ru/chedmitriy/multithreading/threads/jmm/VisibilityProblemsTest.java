package ru.chedmitriy.multithreading.threads.jmm;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *
 */
public class VisibilityProblemsTest {
    private VisibilityProblems vs;
    private ThreadOne t1;
    private ThreadTwo t2;
    @Before
    public void init() {
        vs = new VisibilityProblems();
        t1 = new ThreadOne(vs);
        t2 = new ThreadTwo(vs);

    }
    class ThreadOne extends Thread {
        private final VisibilityProblems vs;

        ThreadOne(final VisibilityProblems vs) {
            super();
            this.vs = vs;
        }

        @Override
        public void run() {
            vs.incrementValue();
            vs.increment();
        }
    }
    class ThreadTwo extends Thread {
        private final VisibilityProblems vs;
        ThreadTwo(final VisibilityProblems vs) {
            super();
            this.vs = vs;
        }
        @Override
        public void run() {
            vs.incrementValue();
            vs.increment();
        }
    }
    @Test
    public void whenSeveralThreadsIsRunning() throws InterruptedException {
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertThat(vs.getValue(), is(2000000));

    }
}