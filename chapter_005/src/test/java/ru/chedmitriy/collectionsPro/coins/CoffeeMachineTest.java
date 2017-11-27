package ru.chedmitriy.collectionsPro.coins;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * ru.chedmitriy.collectionsPro.coins
 *
 * @author cheDmitry
 * @version 1.0
 * @since 27.11.2017
 *
 * тестируем три ситуации:
 *     - на сдачу попадаются несколько монет одного номинала
 *     - все выданные на сдачу монеты разного нноминала(общая сумма сдачи = 18)
 *     - сдачи нет(цена равна внесенной валюте)
 */
public class CoffeeMachineTest {
    private int[] coins;
    private int[] coins1;
    private CoffeeMachine coffeeMachine;
    @Before
    public void init() {
        coffeeMachine = new CoffeeMachine ();
        coins = new int[]{10,10,10,2,1};
        coins1 = new int[]{10,5,2,1};

    }

    @Test
    public void changesWhenAFewArgumentsSame () throws Exception {
        for (int j = 0; j < coffeeMachine.changes (50,17).length ; j++) {
            if(coffeeMachine.changes(50,17)[j] == 0) {
                break;
            }
            assertThat (coffeeMachine.changes (50, 17)[j], is (coins[j]));
        }
    }

    @Test
    public void changesWhenAllArgumentsDifferent () throws Exception {
        for (int j = 0; j < coffeeMachine.changes (50,32).length ; j++) {
            if(coffeeMachine.changes(50,32)[j] == 0) {
                break;
            }
            assertThat (coffeeMachine.changes (50, 32)[j], is (coins1[j]));
        }
    }
    @Test
    public void withoutChanges () throws Exception {
        assertThat (coffeeMachine.changes (50, 50)[0], is (0));

    }


}