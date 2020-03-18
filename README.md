# SPI
### 介绍
硬编码
Java提供的SPI全名就是Service Provider Interface,下面是一段官方的解释,，其实就是为某个接口寻找服务的机制，有点类似IOC的思想，将装配的控制权移交给ServiceLoader。
在Android模块开发中就会比较有用，不同的模块可以基于接口编程，每个模块有不同的实现service provider,然后通过SPI机制自动注册到一个配置文件中，就可以实现在程序运行时扫描加载同一接口的不同service provider。这样模块之间不会基于实现类硬编码，可插拔。

***添加两个组件***一个接口,一个模块实现接口
基本配置实例
```
apply plugin: 'com.android.library'

android {
//删掉appID
    compileSdkVersion 28
    buildToolsVersion "29.0.2"
    defaultConfig {
        minSdkVersion 23
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    implementation project(':libinterface')
}
sourceCompatibility = "1.7"
targetCompatibility = "1.7"
```
注册实现类
在java的同级目录中new一个包目录resources，然后在resources新建一个目录META-INF/services，再新建一个file，file的名称就是接口的全限定名，在我们的栗子中就是：接口module,接口类全路径，文件中就是不同实现类的全限定名，不同实现类分别一行。
示例:com.kt.libinterface.LDisplay  文件内添加 本模块类内实现接口类 :com.kt.spi.MianDisplay