package sql.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.sql.Timestamp;

public class TimestampSerializer extends StdSerializer<Timestamp> {

    public TimestampSerializer() {
        this(null);
    }

    public TimestampSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Timestamp timestamp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(timestamp.toString());
    }
}
