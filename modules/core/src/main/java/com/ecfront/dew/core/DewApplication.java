package com.ecfront.dew.core;

import com.ecfront.dew.core.cluster.ClusterCache;
import com.ecfront.dew.core.cluster.ClusterDist;
import com.ecfront.dew.core.cluster.ClusterMQ;
import com.ecfront.dew.core.config.DewConfig;
import com.ecfront.dew.core.entity.EntityContainer;
import com.ecfront.dew.core.repository.DewRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.MappedSuperclass;

@SpringCloudApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DewRepositoryFactoryBean.class)
@EnableTransactionManagement
@MappedSuperclass
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class, GsonAutoConfiguration.class, WebSocketAutoConfiguration.class})
public abstract class DewApplication {

    @Bean
    @LoadBalanced
    protected RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
