package sql.xml.JAXB;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;

public class JAXBDateAdapter extends XmlAdapter<String, Timestamp> {

    @Override
    public Timestamp unmarshal(String o) throws Exception {
        return Timestamp.valueOf(o);
    }

    @Override
    public String marshal(Timestamp o) throws Exception {
        return o.toString();
    }
}
