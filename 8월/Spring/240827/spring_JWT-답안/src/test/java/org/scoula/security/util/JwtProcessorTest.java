package org.scoula.security.util;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class, SecurityConfig.class })
@Log4j
class JwtProcessorTest {
    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {
        String username = "user0";
        String token = jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }

    @Test
    void getUsername() {
        //String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyMTgwMjc4NCwiZXhwIjoxNzIxODAzMDg0fQ.nwD4rIroYL6hr_-Esav8KIsHw573MbAiTT-Nz_yYHI8bMcyGZMOEjMt0Own3io_c";
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDY0NjM3MywiZXhwIjoxNzI0NjQ2OTczfQ.yLYr82PTXdMFK6tFn0IU8SiFZKUNQ3Lma3c7ZRu10RGk48QUY6HPOq3yBpm3-YdH";
        String username = jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username); //user0
    }

    @Test
    void validateToken() {
        // 5분 경과 후 테스트 ==> 수업시간에는 10분 정도 지나 테스트
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDY0NjM3MywiZXhwIjoxNzI0NjQ2OTczfQ.yLYr82PTXdMFK6tFn0IU8SiFZKUNQ3Lma3c7ZRu10RGk48QUY6HPOq3yBpm3-YdH";

        boolean isValid = jwtProcessor.validateToken(token); // 5분 경과 후면 예외 발생
        log.info("--->> " + isValid);
        assertTrue(isValid);    // 5분전이면 true,
    }
}