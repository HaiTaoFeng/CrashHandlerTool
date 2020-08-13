# CrashHandlerTool
Android捕捉崩溃日志并展示在手机页面，方便开发查看，同时输出日志文件在本地。

1.当app由于异常崩溃时，程序会捕捉崩溃日志，并提示“很抱歉,程序出现异常,即将退出.”。
2.把崩溃日志保存到设置的本地目录中。
3.崩溃的同时会跳转到另外一个页面，并把崩溃日志展示在页面上。


接入方法：
1.在项目根目录的build.gradle中添加maven { url 'https://jitpack.io' }。

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

2.在项目app目录的build.gradle中添加依赖。
implementation 'com.github.HaiTaoFeng:CrashHandlerTool:1.0'

3.点击Sync Now ，等待同步完成。

4.在Application中进行初始化，例如：
 CrashHandler.getInstance().init(this,"/storage/emulated/0/" + getPackageName() + "/");
 
 第一个参数是Context，第二个参数是日志存放路径，格式是：/xxx/
