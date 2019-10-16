package fr.nathanael2611.simpledatabasemanager.core;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * Just contain a data that will be save in the SimpleDatabase V1 databases.
 *
 * @author Nathanael2611, Protoxy22
 */
public class SDM1SavedData implements INBTSerializable<NBTTagCompound> {

    /* The data key */
    String key;
    /* The data value */
    Object value;
    /* The data type */
    private Class object;

    /**
     * Constructor for create a data with assigned key and value
     */
    public SDM1SavedData(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Constructor for create an empty data
     */
    public SDM1SavedData () {
    }

    /**
     * Constructor for create an empty data with data type
     */
    public SDM1SavedData(Class object) {
        this.object = object;
    }

    /**
     * Used to serialize the data to a NBTTagCompound
     */
    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("key", key);
        if(value instanceof String) compound.setString("value", (String) value);
        else if (value instanceof Integer) compound.setInteger("value", (Integer) value);
        else if (value instanceof Double) compound.setDouble("value", (Double) value);
        else if (value instanceof Float) compound.setFloat("value", (Float) value);
        else if (value instanceof Boolean) compound.setBoolean("value", (Boolean) value);
        return compound;
    }

    /**
     * Used to deserialize NBTTagCompound to the data
     */
    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        key = nbt.getString("key");
        if (object.equals(String.class)) this.value = nbt.getString("value");
        if (object.equals(Integer.class)) this.value = nbt.getInteger("value");
        if (object.equals(Double.class)) this.value = nbt.getDouble("value");
        if (object.equals(Float.class)) this.value = nbt.getFloat("value");
        if (object.equals(Boolean.class)) this.value = nbt.getBoolean("value");
    }
}