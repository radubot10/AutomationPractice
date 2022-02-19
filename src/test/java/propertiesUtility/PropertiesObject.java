package propertiesUtility;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesObject {

    public Properties properties;
    public FileInputStream file;

    public PropertiesObject(String path){
        loadPropertiesFile(path);
    }

    //logica pentru a incarca un fisier de tipul properties dupa un anumit path
    public void loadPropertiesFile(String path){
        properties = new Properties();
        try {
            file = new FileInputStream("src/test/resources/"+path+".properties");
            properties.load(file);
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    //logica pentru a returna o valoare pe baza unei chei
    public String getValueByKey(String key){
        return properties.getProperty(key);
    }

    //logica pentru a returna toate chei-valoare dintr-un fisier
    public HashMap<String, String> getAllKeyValues(){
        HashMap<String, String> keyValue = new HashMap<>();
        for (Object key: properties.keySet()) {
            keyValue.put(key.toString(), properties.getProperty(key.toString()));
        }
        return keyValue;
    }
}
