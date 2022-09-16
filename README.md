# AutoConnect
自动连接南信大校园网
只需要运行这个main函数就可以发送连接请求。

然后可以导出这个程序为jar包，在jar包同级目录下新建一个配置文件config.txt

其中第一行写你的网络运营商：移动、电信、联通

第二行写账号，第三行写密码

然后写一个bat脚本，内容是java - jar +你的jar包绝对路径

如我的是：java -jar F:\WorkSpace\Java\IdeaUltimate\AutoConnect\out\artifacts\consoleApp_jar\consoleApp.jar

然后吧bat脚本放在开机自启动目录（C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp）中，就可以实现开机自动连接校园网
