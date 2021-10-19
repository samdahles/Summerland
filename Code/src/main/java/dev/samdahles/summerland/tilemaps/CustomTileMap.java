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

import dev.samdahles.summerland.entities.tiles.TileEntity;

public class CustomTileMap {
	private List<TileEntity> Tiles = new ArrayList<TileEntity>();
	private String mapName;
	
	public CustomTileMap(String mapName) {
		this.mapName = mapName;
		createTileEntities();
	}
	
	public List<TileEntity> getTiles() {
		return Tiles;
	}
	private void createTileEntities() {
		List<TileEntity> list = new ArrayList<TileEntity>();
		List<int[][]> TileMaps = csvToTileMap();
		for (int[][] TileMap : TileMaps) {
			for (int row = 0; row < TileMap.length; row++) {
				for (int column = 0; column < TileMap[row].length; column++) {

					if (TileMap[row][column] == 0) {
						continue;
					}
					TileEntity tile = new TileEntity(new Coordinate2D(32 * column, 32 * row - 32), new Size(32), TileMap[row][column] - 1);
					list.add(tile);
				}
			}
		}
		Tiles = list;
	}

	private List<int[][]> csvToTileMap() {
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

		List<int[][]> tilemaps = new ArrayList<>();
		NodeList nodeList = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				if (currentNode.getNodeName() == "layer") {
					int[][] TileMap = new int[30][30];
					String[] tileRows = currentNode.getChildNodes().item(1).getTextContent().split("\n");
					tileRows = Arrays.copyOfRange(tileRows, 1, tileRows.length);
					for (int row = 1; row < tileRows.length; row++) {
						String[] rowArray = tileRows[row].trim().strip().split(",");
						for (int column = 0; column < rowArray.length; column++) {
							TileMap[row][column] = Integer.parseInt(rowArray[column]);
						}
					}
					tilemaps.add(TileMap);
				}
			}
		}

		for (int[][] cache : tilemaps) {
			System.out.println(Arrays.deepToString(cache));
		}
		return tilemaps;
	}
}
