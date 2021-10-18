package com.bootcamp.spring08;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Configuration
@ConditionalOnClass(SchoolService.class)
@EnableConfigurationProperties(SchoolProperties.class)
public class SchoolAutoConfiguration {

    /**
     * 注入属性配置类
     */
    @Resource
    private SchoolProperties schoolProperties;

    @Bean
    @ConditionalOnMissingBean(SchoolService.class)
    @ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
    public SchoolService schoolService() {
        Student student100 = new Student();
        student100.setId(schoolProperties.getStudent100Id());
        student100.setName(schoolProperties.getStudent100Name());

        Student student123 = new Student();
        student123.setId(schoolProperties.getStudent123Id());
        student123.setName(schoolProperties.getStudent123Name());

        List<Student> students = Arrays.asList(student100, student123);
        Klass klass = new Klass();
        klass.setStudents(students);
        SchoolService schoolService = new SchoolService(klass, student100);
        return schoolService;
    }
}
