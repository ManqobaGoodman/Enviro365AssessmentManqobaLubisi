package com.eviro.assessment.grad001.ManqobaLubisi;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class ManqobaLubisiApplicationTests {

    @Test
    void itShouldAAddNumbers() {
        //given
        int num1 = 20;
        int num2 = 30;

        //when
        int result = num1 + num2;

        //then
        int expected = 50;
        
        assertThat(result).isEqualTo(expected);


    }

    class calcutater {

        int sum(int num1, int num2) {
            return num1 + num2;
        }

    }
}
