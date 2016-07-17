package model.webappStat;

public interface WebAppStatistique {
    public boolean addStatValue(String value, Integer initial);
    public boolean updateValue(String value, Integer toAdd );
    public boolean deletValue(String value, Integer toAdd );
    public boolean resetValue(String value, Integer toAdd );
    public boolean resetAll();
}
