package com.heaven.learnspringframework.game;

import com.heaven.learnspringframework.game.GameRunner;
import com.heaven.learnspringframework.game.MarioGame;
import com.heaven.learnspringframework.game.SuperContraGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.heaven.learnspringframework.game")
public class AppGamingBasic {
//        @Bean
//        public GamingConsole game(){
//            return new MarioGame();
//        }
//        @Bean
//        public GameRunner gameRunner(GamingConsole game){
//            var gamr = new GameRunner(game);
//            return gamr;
//        }
}
