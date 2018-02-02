package com.xiaoyao.designModel.handler;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * handler 抽象
 * 实现类直接实现就可以了。不再重复书写
 */
public abstract class AbstractHandler {
    private AbstractHandler nextHandler;

    /**
     * 不允许重写
     * @param r
     * @return
     */
    public final Response handleMessage(Request r){
        Response response = null;
        // 判断是否是自己的处理级别
        if(this.getHandlerLevel().equals(r.getRequestLevel())){
            response = this.echo(r);
        }else {
            if(this.nextHandler != null){
                response = this.nextHandler.handleMessage(r);
            }else {
                // 适当处理
            }
        }
        return  response;
    }
    public void setNextHandler(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    // 获取处理级别
    protected abstract Level getHandlerLevel();
    // 每个 handler 都必须实现的处理任务
    protected abstract Response echo(Request r);
}
