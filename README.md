# AARTest
aar文件的生成和使用以及注意事项<br>
写这个测试项目的是源自jar做sdk不能封装资源文件，而用apk做sdk存在一定的弊端，比如说新大楼的N900设备，为了安全只能使用一个签名证书，这样就限制了第三方厂家使用sdk
，正好Androidstudio上生产aar文件很方便，so.....<br>

1.新建一个module,选择library<br>
2.然后在module里写内容，注意资源文件的命令最好是库名开头，例如module名字是aar_library,则图片命名可以这样aar_library_xx.png,布局文件命令aar_library_yy.xml<br>
3.在module中的build.gradle文件中配置混淆操作，这样可以混淆class文件。把minifyEnabled设置为true，在proguard-rules.pro，配置那些需要混淆，哪些不需要混淆，例如我在配置文件里配置了不混淆，BitmapUtil文件<br>
4.基本的规范和配置就整完，然后到找到Gradle projects,点击下同步刷新，然后在找到对应的aar_library模块，点开build文件夹，里面有个assembleRelease,此时真个项目都会编译一次，然后在project模式下aar_library的build文件下的ouputs文件中的aar找到aar_library_release.aar
这个就是我要的文件，里面包括了class文件和资源文件<br>


# 另做说明
这个项目只是生产aar文件，我在另一个项目MiSee中进行测试，这里把在MiSee中的配置也写下<br>
1.把aar_library_release.aar直接拷贝到主项目app的libs中<br>
2.在app的build.gradle中的配置如下<br>
在android{<br>
...<br>
//新加入下代码<br>
repositories {<br>
        flatDir {<br>
            dirs 'libs'<br>
        }<br>
    }<br>
}
<br>
在dependencies {<br>
  ...<br>
  //新加如下代码<br>
    compile(name:'aar_library-release', ext:'aar')<br>

}<br>
3.然后重新build项目就ok，如果ok了则可以在External Libraries中可以看到<br>


