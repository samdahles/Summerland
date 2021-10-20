module Summerland {
    requires hanyaeger;
	requires jsr305;
	requires java.xml;
	requires transitive javafx.graphics;
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
