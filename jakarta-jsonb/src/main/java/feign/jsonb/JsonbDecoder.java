/*
 * Copyright 2012-2023 The Feign Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package feign.jsonb;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.EncodeException;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

/**
 * Decodes responses using the configured Jsonb decoder.
 */
public class JsonbDecoder implements Decoder {

  @Override
  public Object decode(Response response, Type type)
      throws IOException, DecodeException, FeignException {
    try (Jsonb jsonb = JsonbBuilder.create();
        Reader reader = response.body().asReader(response.charset())) {
      return jsonb.fromJson(reader, type);
    } catch (Exception e) {
      throw new EncodeException(e.getMessage(), e);
    }
  }

}
