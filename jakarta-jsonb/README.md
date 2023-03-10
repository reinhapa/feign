Jakarta JSON Binding based Codec
================================

This module adds support for encoding and decoding [JSON][] via [JSONB][].

Add `JsonbEncoder` and/or `JsonbDecoder` to your `Feign.Builder` like so:

```java
api = Feign.builder()
           .decoder(new JsonbDecoder())
           .encoder(new JsonbEncoder())
           .target(GitHub.class, "https://api");
```

[JSON]: https://www.json.org/json-en.html
[JSONB]: https://jakarta.ee/specifications/jsonb
