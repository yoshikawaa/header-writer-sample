## Spring Security HeaderWriter Sample

### To Run

```console
mvn clean package cargo:run
```

### To Access

* `http://localhost:8080/header-writer-sample/auto-config`

   -> `sec:headers` provide Response headers `Cache-Control`,`Pragma`,`Expires`.

* `http://localhost:8080/header-writer-sample/delegating`

   -> `DelegatingRequestMatcherHeaderWriter` can not completely match request path, not provide Response headers.

* `http://localhost:8080/header-writer-sample/delegatingex`

   -> Fix `DelegatingRequestMatcherHeaderWriter` to can match request path, provide Response headers.