package com.yangweiyao.springframework.beans.factory.support;

import com.yangweiyao.springframework.beans.BeansException;
import com.yangweiyao.springframework.beans.factory.BeanFactory;
import com.yangweiyao.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private InstantiationStrategy instantiationStrategy;

    public DefaultListableBeanFactory () {
        // 默认JDK实例化
        this.instantiationStrategy = new SimpleInstantiationStrategy();
    }

    public DefaultListableBeanFactory (InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) throw new BeansException("No bean named '" + name + "' is defined");
        return beanDefinition;
    }

    @Override
    protected InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }
}
