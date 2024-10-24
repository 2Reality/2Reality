package com.back2reality.common;

import com.back2reality.recommender.context.ContextExtractionFactory;
import com.back2reality.recommender.context.DummyContext;
import com.back2reality.recommender.context.RecommenderContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLIGHT
 */

@Configuration
public class CommonContextConfiguration {

    @Bean
    public RecommenderContext recommenderContext() {
        return new DummyContext();
    }

    @Bean
    public ContextExtractionFactory contextExtractionFactory(RecommenderContext recommenderContext) {
        return () -> recommenderContext;
    }
}
