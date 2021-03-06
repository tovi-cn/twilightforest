package twilightforest.structures.darktower;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.structure.StructureComponent;

import java.util.List;
import java.util.Random;

public class ComponentTFDarkTowerEntranceBridge extends ComponentTFDarkTowerBridge {

	public ComponentTFDarkTowerEntranceBridge() {
	}

	protected ComponentTFDarkTowerEntranceBridge(int i, int x, int y, int z, int pSize, int pHeight, EnumFacing direction) {
		super(i, x, y, z, pSize, pHeight, direction);
	}

	@Override
	public boolean makeTowerWing(List<StructureComponent> list, Random rand, int index, int x, int y, int z, int wingSize, int wingHeight, Rotation rotation) {
		// make an entrance tower
		EnumFacing direction = getStructureRelativeRotation(rotation);
		int[] dx = offsetTowerCoords(x, y, z, wingSize, direction);

		ComponentTFDarkTowerWing wing = new ComponentTFDarkTowerEntrance(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);

		list.add(wing);
		wing.buildComponent(this, list, rand);
		addOpening(x, y, z, rotation);
		return true;
	}
}
