package dev.samdahles.summerland.tilemaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import dev.samdahles.summerland.entities.tiles.ColliderTile;
import dev.samdahles.summerland.entities.tiles.NormalTile;
import dev.samdahles.summerland.entities.tiles.TileEntity;

public class CustomTileMap {
	private List<TileEntity> Tiles = new ArrayList<TileEntity>();
	private String mapName;

	public CustomTileMap(String mapName) {
		this.mapName = mapName;
		tmxToTileMap();
	}

	public List<TileEntity> getTiles() {
		return Tiles;
	}

	private void tmxToTileMap() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setNamespaceAware(true);
		dbf.setIgnoringElementContentWhitespace(true);

		Document doc = null;
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			// builder.setErrorHandler(new ErrorHandler());
			InputSource is = new InputSource("src/main/resources/Maps/" + mapName + ".tmx");
			doc = builder.parse(is);

		} catch (Exception e) {
			System.err.println(e);
		}

		List<TileEntity> tileMaps = new ArrayList<>();
		NodeList nodeList = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				if (currentNode.getNodeName() == "layer") {
					List<TileEntity> tileMap = new ArrayList<>();
					String[] tileRows = currentNode.getChildNodes().item(1).getTextContent().split("\n");
					tileRows = Arrays.copyOfRange(tileRows, 1, tileRows.length);

					for (int row = 1; row < tileRows.length; row++) {
						String[] rowArray = tileRows[row].trim().strip().split(",");

						for (int column = 0; column < rowArray.length; column++) {
							int TileId = Integer.parseInt(rowArray[column]);
							if (TileId == 0) {
								continue;
							}

							String currentLayerName = currentNode.getAttributes().item(2).getTextContent();
							int height = 1;
							if (currentLayerName.equals("Ground") || currentLayerName.equals("Flowers")) {
								height = 1;
								tileMap.add(new NormalTile(new Coordinate2D(32 * column, 32 * row - 32), new Size(32),
										TileId - 1, height));
							} else if (currentLayerName.equals("Buildings") || currentLayerName.equals("Building Props")
									|| currentLayerName.equals("Beach") || currentLayerName.equals("Props")
									|| currentLayerName.equals("Door") || currentLayerName.equals("Door 2")
									|| currentLayerName.equals("Riser")) {
								height = 4;
								tileMap.add(new ColliderTile(new Coordinate2D(32 * column, 32 * row - 32), new Size(32),
										TileId - 1, height));
							}
						}
					}
					tileMaps.addAll(tileMap);
				}
			}
		}
		Tiles = tileMaps;
	}
}
