package net.minecraft.client;

import titan.Client;

public class ClientBrandRetriever
{
    public static String getClientModName()
    {
        return Client.INSTANCE.NAME;
    }
}
