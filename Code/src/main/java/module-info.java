module Summerland {
    requires hanyaeger;
	requires jsr305;

    exports dev.samdahles.summerland;
    
    opens Fonts;
    opens Music;
    opens Images;
}
