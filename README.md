# Easy-Signature-Android

<img src="https://github.com/smalam119/Easy-Signature-Android/blob/master/Screenshot_2017-12-26-02-44-08.png" align="center" width="300"/>
A simple and easy signature view.
</br>

* It provides a Activity where an signature can be drawn.
* Signature is returned in either bitmap or array of bytes.
* Has callbacks for okay and cancel button.
* Has a Cross button to clear view.
* Also, Sub text can be added.
* Just create a class and extend 'SignatureViewActivity'

```java
public class DemoSignatureViewController extends SignatureViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set sub text
        this.setSubText("I accept the nothingness and meaninglessness of life");
    }

    //call back for done button click. returns bitmap
    @Override
    public void onClickDone(Bitmap bitmap) {
    }

    //call back for done button click. returns array of byte
    @Override
    public void onClickDone(byte[] bytes) {
    }

    //callback for cancel button click
    @Override
    public void onClickCancel() {
    }

}
```

Download
--------

First, add jitpack. Add this in your root build.gradle:

```groovy
allprojects {
  repositories {
    ...
      maven { url 'https://jitpack.io' }
   }
}
```
Then, go to the module level build.gradle file and add,

```groovy
dependencies {
  compile 'com.github.smalam119:Easy-Signature-Android:0.1.0'
}
```
