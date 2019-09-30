package com.akurat.sms.config;

import org.hibernate.service.ServiceRegistry;
import org.infinispan.hibernate.cache.v53.InfinispanRegionFactory;
import org.infinispan.manager.EmbeddedCacheManager;

import java.util.Properties;

/**
 * Factory class for initializing Hibernate 2nd-level cache with Infinispan cache.
 *
 * <p>
 * This will be created through reflection. With Hibernate 5, support
 * to manage this cache through Spring has been removed and there is no way to inject it using
 * Dependency Injection. This needs to be initialized from
 * {@link CacheConfiguration#cacheConfigurer(io.github.jhipster.config.JHipsterProperties) CacheConfiguration } to keep the same cache manager
 * between the Spring Cache and Hibernate.
 */
public class CacheFactoryConfiguration extends InfinispanRegionFactory {

    private static final long serialVersionUID = 1L;

    /**
     * Defines a Hibernate L2 cache: infinispan-hibernate-cache.
     */
    @Override
    protected EmbeddedCacheManager createCacheManager(Properties properties, ServiceRegistry serviceRegistry) {
        // Not a managed bean from the Spring Context (as it gets created through reflection) and hence override the static instance
        return CacheConfiguration.getCacheManager();
    }

}
