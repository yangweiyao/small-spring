package com.yangweiyao.springframework.context;

import com.yangweiyao.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册虚拟机钩子
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭
     */
    void close();

}
