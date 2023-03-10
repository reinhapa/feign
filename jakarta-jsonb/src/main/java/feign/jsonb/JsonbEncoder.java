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

import java.lang.reflect.Type;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

/**
 * Encodes responses using the configured Jsonb encoder.
 */
public class JsonbEncoder implements Encoder {

  @Override
  public void encode(Object object, Type bodyType, RequestTemplate template)
      throws EncodeException {
    try (Jsonb jsonb = JsonbBuilder.create()) {
      template.body(jsonb.toJson(object));
    } catch (Exception e) {
      throw new EncodeException(e.getMessage(), e);
    }
  }

}
