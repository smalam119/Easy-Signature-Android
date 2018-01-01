# Easy-Signature-Android


<img src="https://github.com/smalam119/Easy-Signature-Android/blob/master/Screenshot_2017-12-31-23-29-09.png" align="center" width="300"/>

## **A simple and easy signature view.**

Features
=======

* A signature view provided as a activty.
* Signature is returned in either bitmap or array of bytes.
* Callbacks for okay and cancel button.
* Cross button to clear view.
* Editable sub-text
* Signature date.

Download
=======

First, add this in your root build.gradle:

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
  compile 'com.github.smalam119:Easy-Signature-Android:0.3.0'
}
```
Example
=======

The example is quite straightforward and documented in comments. Just create a class and extend 'SignatureViewActivity' then implement accordingly. Remember to register the class as activity in manifast file.

```java
public class DemoSignatureViewController extends SignatureViewActivity {
    private Date mDate;
    private Bitmap mSignatureBitmap;
    private byte[] mSignatureInBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set sub text
        this.setSubText("I accept the nothingness and meaninglessness of life");
    }

    //call back for done button click. returns bitmap
    @Override
    public void onClickDone(Bitmap bitmap) {
        mDate = this.getDate(); //get the date of the signature
        mSignatureBitmap = bitmap; // signature in bitmap
    }

    //call back for done button click. returns array of byte
    @Override
    public void onClickDone(byte[] bytes) {
        mSignatureInBytes = bytes; //signature in bytes
    }

    //callback for cancel button click
    @Override
    public void onClickCancel() {
    }

}
```
Author
=======
* **Sayed Mahmudul Alam**

License
=======

    Copyright 2017 Sayed Mahmudul Alam

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

