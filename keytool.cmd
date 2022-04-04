keytool -genkey -noprompt \
-alias pure-awesomeness \
-storetype PKCS12 \
-keyalg RSA \
-keysize 2048 \
-dname "CN=pure-awesomeness" \
-keystore pure-awesomeness-keystore.p12 \
-validity 3650 \
-storepass 123456 \
-keypass 123456