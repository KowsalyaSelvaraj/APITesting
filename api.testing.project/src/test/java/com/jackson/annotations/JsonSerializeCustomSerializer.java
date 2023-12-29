package com.jackson.annotations;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JsonSerializeCustomSerializer extends StdSerializer<JsonSerializePOJO>{

	protected JsonSerializeCustomSerializer(Class<JsonSerializePOJO> t) {
		super(t);
		
	}

	public JsonSerializeCustomSerializer() {
		this(null);
	}

	@Override
	public void serialize(JsonSerializePOJO value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		
		generator.writeStartObject();
		
		generator.writeStringField("first_Name", value.getNameString());
		generator.writeStringField("email_Id", value.getEmailString());
		generator.writeStringField("skills_List", value.getSkillStrings().toString());
		
		generator.writeEndObject();
	}
	
	
	

}
