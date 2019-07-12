# mina-to-dubbo

## 演示如何把skyroam的现有项目结构优化

- 去除所有shell脚本，为Cloud Native做准备
- 原模块独立出来作为Application，为微服务做基础准备
  - [x] **One jar 发布**
  - [x] **独立的Application**


## 验证原设计的fatal缺陷

- [ ] Executor、Runnable是否真的有助提升性能？
- [ ] 验证模块间mina异步方式是否真的有助提升性能？
- [ ] 验证模块间mina改为同步调用可行性？
- [ ] 验证原代码中四个自定义池（mina连接池）可行性？（mina自带ioprocessor池）


## 演示二方库、三方库的最佳实践

- baseprotocol项目是本项目依赖的二方库

- minatodubboclient项目是本项目的客户端（for 测试）

- mina、spring、log4j等lib是本项目依赖的三方库

  *理论上二方库和三方库是同级的概念*
  
