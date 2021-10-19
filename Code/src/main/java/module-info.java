module Summerland {
    requires hanyaeger;
	requires jsr305;
	requires java.xml;

    exports dev.samdahles.summerland;
    
    opens Fonts;
    opens Music;
    opens Images;
    opens Maps;
}
