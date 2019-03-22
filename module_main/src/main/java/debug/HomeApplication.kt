package debug

import com.frame.mvp.common.base.BaseApplication

/**
 *
 * 类说明
 *
 * @author 张华洋 2017/2/15 20:09
 * @version V1.2.0
 * @name HomeApplication
 */
class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        login()
    }

    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private fun login() {
    }
}
