package ayds.dictionary.alpha.Model.Repository.Service;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import SearchService.ServiceNotReachableException;

public interface ServiceAdapter {

    String getTerm(String term) throws IOException, SAXException, ParserConfigurationException, ServiceNotReachableException, Exception;
}
