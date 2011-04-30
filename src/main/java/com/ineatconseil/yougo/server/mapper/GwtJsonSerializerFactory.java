package com.ineatconseil.yougo.server.mapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.map.ser.ToStringSerializer;

/**
 * GWT json serializer factory used to map GWT specificity : - GWT does not support correctly long type, so long are
 * serialized into String
 * @author aelamrani
 */
public class GwtJsonSerializerFactory extends CustomSerializerFactory {

	/**
	 * Default constructor
	 */
	public GwtJsonSerializerFactory() {
		addGenericMapping(Long.class, ToStringSerializer.instance);
		addGenericMapping(long.class, ToStringSerializer.instance);
		addGenericMapping(Date.class, new SerializerBase<Date>(Date.class) {
			@Override
			public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
					JsonGenerationException {
				jgen.writeNumber(value.getTime());
			}

			@Override
			public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
				return createSchemaNode("number", true);
			}

		});
	}

}
