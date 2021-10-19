module Summerland {
    requires hanyaeger;
	requires jsr305;

    exports dev.samdahles.summerland;
    
    opens Fonts;
    opens Music;
    opens Images;
    opens CharSprites.Heggard;
    opens CharSprites.Nate;
    opens CharSprites.Rhett;

    
}
