# AsyncHttpClient
 
```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
 
```
implementation 'com.github.dron4ik89:AsyncHttpClient:0.0.9'
```

### Methods:
***GET, HEAD, POST, PUT, PATCH, DELETE***

```
HttpCodeResponseHelper - onli statusCode

HttpHeadResponseHelper - onli statusCode & headers

HttpTextResponseHelper - onli statusCode & bodyContent

HttpResponseHelper - full data

HttpBytesResponseHelper - onli statusCode & byteArray

HttpByteStreamResponseHelper - onli statusCode & byteStream

HttpCharStreamResponseHelper - onli statusCode & charStream
```
