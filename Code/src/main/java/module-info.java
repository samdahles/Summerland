module Summerland {
    requires transitive hanyaeger;
	requires transitive jsr305;
	requires transitive java.xml;
	requires transitive javafx.graphics;
	requires transitive javafx.base;
    exports dev.samdahles.summerland;
    
    opens Fonts;
    opens Music;
    opens Images;
    opens CharSprites.Heggard;
    opens CharSprites.Nate;
    opens CharSprites.Rhett;
    opens Maps;
    opens Tiles;
}
