package me.flashyreese.mods.fabricskyboxes_interop.utils;

import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.stream.Stream;

public class ResourceManagerHelper {
    private final ResourceManager resourceManager;

    public ResourceManagerHelper(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    public Stream<Identifier> searchIn(Identifier parent) {
        return this.resourceManager.findResources(parent.getPath(), path -> true).stream();
    }

    public InputStream getInputStream(Identifier identifier) {
        try {
            Resource resource = this.resourceManager.getResource(identifier);
            return resource.getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    public Collection<String> getNamespaces() {
        return this.resourceManager.getAllNamespaces();
    }
}