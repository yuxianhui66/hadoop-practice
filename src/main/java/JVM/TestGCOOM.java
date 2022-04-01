package JVM;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.StringReader;

/**
 * @author yuxianhui
 * @create 2020-12-24 13:56
 **/
@XmlRootElement
public class TestGCOOM {
    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><testGCOOM test=\"test\" />";

    @XmlAttribute
    String test;

    public static void main( String[] args ) throws Exception
    {
        System.out.println("start");

        while ( true )
        {
            //VM参数:-XX:+TraceClassLoading -XX:+TraceClassUnloading -XX:MaxMetaspaceSize=16M -XX:MetaspaceSize=1M -XX:+UseParallelOldGC -XX:+HeapDumpOnOutOfMemoryError
            //元空间内存泄露
            TestGCOOM testGC =xmlToBean(XML, TestGCOOM.class);
            System.out.println( testGC.test );
//            JAXBContext jc = JAXBContext.newInstance( TestGCOOM.class );
//            Unmarshaller unmarshaller = jc.createUnmarshaller();
//            TestGCOOM object = (TestGCOOM) unmarshaller.unmarshal( new ByteArrayInputStream( XML.getBytes() ) );
//            System.out.println( object.test );
        }
    }

    public static <T> T xmlToBean(String str, Class<T> clazz) throws JAXBException, SAXException,
            ParserConfigurationException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(str);

        SAXParserFactory sax = SAXParserFactory.newInstance();
        sax.setNamespaceAware(false);// 忽略命名空间
        XMLReader xmlReader = sax.newSAXParser().getXMLReader();

        Source source = new SAXSource(xmlReader, new InputSource(reader));
        return (T) unmarshaller.unmarshal(source);
    }
}
