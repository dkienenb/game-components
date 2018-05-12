package org.gamenet.dkienenb.graphics.javafx;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

/**
 * This class stores images by key names. To load images, call the {@link #loadImages(Map)} method with a map of relative filenames to image names.
 */
public class ResourceManager {

	private Map<String, Image> imageByImageNameMap = new HashMap<>();

	public Image getImage(String key) {
		return imageByImageNameMap.get(key);
	}

	public void loadImages(Map<String, String> imageNameByResourceNameMap) {
		imageNameByResourceNameMap.keySet().stream()
			.forEach(resourceName -> {
				loadImage(imageNameByResourceNameMap.get(resourceName), resourceName);
			});
	}

	public void loadImage(String imageName, String resourceName) {
		Image image = new Image(ImageDrawer.class.getResourceAsStream(resourceName));
		imageByImageNameMap.put(imageName, image);
	}
}
