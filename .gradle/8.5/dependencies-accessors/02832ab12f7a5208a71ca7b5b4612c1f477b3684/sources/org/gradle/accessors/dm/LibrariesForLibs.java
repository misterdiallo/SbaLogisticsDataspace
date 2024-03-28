package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ApacheLibraryAccessors laccForApacheLibraryAccessors = new ApacheLibraryAccessors(owner);
    private final AzureLibraryAccessors laccForAzureLibraryAccessors = new AzureLibraryAccessors(owner);
    private final EdcLibraryAccessors laccForEdcLibraryAccessors = new EdcLibraryAccessors(owner);
    private final FcLibraryAccessors laccForFcLibraryAccessors = new FcLibraryAccessors(owner);
    private final GatlingLibraryAccessors laccForGatlingLibraryAccessors = new GatlingLibraryAccessors(owner);
    private final IhLibraryAccessors laccForIhLibraryAccessors = new IhLibraryAccessors(owner);
    private final RsLibraryAccessors laccForRsLibraryAccessors = new RsLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for assertj (org.assertj:assertj-core)
     * with versionRef 'assertj'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAssertj() {
            return create("assertj");
    }

        /**
         * Creates a dependency provider for awaitility (org.awaitility:awaitility)
     * with versionRef 'awaitility'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAwaitility() {
            return create("awaitility");
    }

        /**
         * Creates a dependency provider for okhttp (com.squareup.okhttp3:okhttp)
     * with versionRef 'okhttp'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp() {
            return create("okhttp");
    }

        /**
         * Creates a dependency provider for restAssured (io.rest-assured:rest-assured)
     * with versionRef 'restAssured'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRestAssured() {
            return create("restAssured");
    }

    /**
     * Returns the group of libraries at apache
     */
    public ApacheLibraryAccessors getApache() {
        return laccForApacheLibraryAccessors;
    }

    /**
     * Returns the group of libraries at azure
     */
    public AzureLibraryAccessors getAzure() {
        return laccForAzureLibraryAccessors;
    }

    /**
     * Returns the group of libraries at edc
     */
    public EdcLibraryAccessors getEdc() {
        return laccForEdcLibraryAccessors;
    }

    /**
     * Returns the group of libraries at fc
     */
    public FcLibraryAccessors getFc() {
        return laccForFcLibraryAccessors;
    }

    /**
     * Returns the group of libraries at gatling
     */
    public GatlingLibraryAccessors getGatling() {
        return laccForGatlingLibraryAccessors;
    }

    /**
     * Returns the group of libraries at ih
     */
    public IhLibraryAccessors getIh() {
        return laccForIhLibraryAccessors;
    }

    /**
     * Returns the group of libraries at rs
     */
    public RsLibraryAccessors getRs() {
        return laccForRsLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ApacheLibraryAccessors extends SubDependencyFactory {
        private final ApacheCommonsLibraryAccessors laccForApacheCommonsLibraryAccessors = new ApacheCommonsLibraryAccessors(owner);

        public ApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at apache.commons
         */
        public ApacheCommonsLibraryAccessors getCommons() {
            return laccForApacheCommonsLibraryAccessors;
        }

    }

    public static class ApacheCommonsLibraryAccessors extends SubDependencyFactory {

        public ApacheCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for lang3 (org.apache.commons:commons-lang3)
         * with versionRef 'apacheCommons'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLang3() {
                return create("apache.commons.lang3");
        }

    }

    public static class AzureLibraryAccessors extends SubDependencyFactory {

        public AzureLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for identity (com.azure:azure-identity)
         * with version '1.11.2'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getIdentity() {
                return create("azure.identity");
        }

            /**
             * Creates a dependency provider for keyvault (com.azure:azure-security-keyvault-secrets)
         * with version '4.7.3'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKeyvault() {
                return create("azure.keyvault");
        }

            /**
             * Creates a dependency provider for storageblob (com.azure:azure-storage-blob)
         * with version '12.25.1'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStorageblob() {
                return create("azure.storageblob");
        }

    }

    public static class EdcLibraryAccessors extends SubDependencyFactory {
        private final EdcAzureLibraryAccessors laccForEdcAzureLibraryAccessors = new EdcAzureLibraryAccessors(owner);
        private final EdcCoreLibraryAccessors laccForEdcCoreLibraryAccessors = new EdcCoreLibraryAccessors(owner);
        private final EdcExtLibraryAccessors laccForEdcExtLibraryAccessors = new EdcExtLibraryAccessors(owner);
        private final EdcProtocolLibraryAccessors laccForEdcProtocolLibraryAccessors = new EdcProtocolLibraryAccessors(owner);
        private final EdcSpiLibraryAccessors laccForEdcSpiLibraryAccessors = new EdcSpiLibraryAccessors(owner);

        public EdcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at edc.azure
         */
        public EdcAzureLibraryAccessors getAzure() {
            return laccForEdcAzureLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.core
         */
        public EdcCoreLibraryAccessors getCore() {
            return laccForEdcCoreLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext
         */
        public EdcExtLibraryAccessors getExt() {
            return laccForEdcExtLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.protocol
         */
        public EdcProtocolLibraryAccessors getProtocol() {
            return laccForEdcProtocolLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.spi
         */
        public EdcSpiLibraryAccessors getSpi() {
            return laccForEdcSpiLibraryAccessors;
        }

    }

    public static class EdcAzureLibraryAccessors extends SubDependencyFactory {
        private final EdcAzureCoreLibraryAccessors laccForEdcAzureCoreLibraryAccessors = new EdcAzureCoreLibraryAccessors(owner);
        private final EdcAzureExtLibraryAccessors laccForEdcAzureExtLibraryAccessors = new EdcAzureExtLibraryAccessors(owner);

        public EdcAzureLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at edc.azure.core
         */
        public EdcAzureCoreLibraryAccessors getCore() {
            return laccForEdcAzureCoreLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.azure.ext
         */
        public EdcAzureExtLibraryAccessors getExt() {
            return laccForEdcAzureExtLibraryAccessors;
        }

    }

    public static class EdcAzureCoreLibraryAccessors extends SubDependencyFactory {

        public EdcAzureCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for blob (org.eclipse.edc:azure-blob-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBlob() {
                return create("edc.azure.core.blob");
        }

    }

    public static class EdcAzureExtLibraryAccessors extends SubDependencyFactory {
        private final EdcAzureExtDpfLibraryAccessors laccForEdcAzureExtDpfLibraryAccessors = new EdcAzureExtDpfLibraryAccessors(owner);
        private final EdcAzureExtProvisionLibraryAccessors laccForEdcAzureExtProvisionLibraryAccessors = new EdcAzureExtProvisionLibraryAccessors(owner);

        public EdcAzureExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for vault (org.eclipse.edc:vault-azure)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getVault() {
                return create("edc.azure.ext.vault");
        }

        /**
         * Returns the group of libraries at edc.azure.ext.dpf
         */
        public EdcAzureExtDpfLibraryAccessors getDpf() {
            return laccForEdcAzureExtDpfLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.azure.ext.provision
         */
        public EdcAzureExtProvisionLibraryAccessors getProvision() {
            return laccForEdcAzureExtProvisionLibraryAccessors;
        }

    }

    public static class EdcAzureExtDpfLibraryAccessors extends SubDependencyFactory {

        public EdcAzureExtDpfLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for storage (org.eclipse.edc:data-plane-azure-storage)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStorage() {
                return create("edc.azure.ext.dpf.storage");
        }

    }

    public static class EdcAzureExtProvisionLibraryAccessors extends SubDependencyFactory {

        public EdcAzureExtProvisionLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for blob (org.eclipse.edc:provision-blob)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBlob() {
                return create("edc.azure.ext.provision.blob");
        }

    }

    public static class EdcCoreLibraryAccessors extends SubDependencyFactory {
        private final EdcCoreControlplaneLibraryAccessors laccForEdcCoreControlplaneLibraryAccessors = new EdcCoreControlplaneLibraryAccessors(owner);
        private final EdcCoreDpfLibraryAccessors laccForEdcCoreDpfLibraryAccessors = new EdcCoreDpfLibraryAccessors(owner);
        private final EdcCorePolicyLibraryAccessors laccForEdcCorePolicyLibraryAccessors = new EdcCorePolicyLibraryAccessors(owner);
        private final EdcCoreTransformLibraryAccessors laccForEdcCoreTransformLibraryAccessors = new EdcCoreTransformLibraryAccessors(owner);

        public EdcCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for boot (org.eclipse.edc:boot)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBoot() {
                return create("edc.core.boot");
        }

            /**
             * Creates a dependency provider for connector (org.eclipse.edc:connector-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConnector() {
                return create("edc.core.connector");
        }

            /**
             * Creates a dependency provider for jersey (org.eclipse.edc:jersey-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJersey() {
                return create("edc.core.jersey");
        }

            /**
             * Creates a dependency provider for junit (org.eclipse.edc:junit)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() {
                return create("edc.core.junit");
        }

            /**
             * Creates a dependency provider for micrometer (org.eclipse.edc:micrometer-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMicrometer() {
                return create("edc.core.micrometer");
        }

            /**
             * Creates a dependency provider for util (org.eclipse.edc:util)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUtil() {
                return create("edc.core.util");
        }

        /**
         * Returns the group of libraries at edc.core.controlplane
         */
        public EdcCoreControlplaneLibraryAccessors getControlplane() {
            return laccForEdcCoreControlplaneLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.core.dpf
         */
        public EdcCoreDpfLibraryAccessors getDpf() {
            return laccForEdcCoreDpfLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.core.policy
         */
        public EdcCorePolicyLibraryAccessors getPolicy() {
            return laccForEdcCorePolicyLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.core.transform
         */
        public EdcCoreTransformLibraryAccessors getTransform() {
            return laccForEdcCoreTransformLibraryAccessors;
        }

    }

    public static class EdcCoreControlplaneLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final EdcCoreControlplaneApiLibraryAccessors laccForEdcCoreControlplaneApiLibraryAccessors = new EdcCoreControlplaneApiLibraryAccessors(owner);

        public EdcCoreControlplaneLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for controlplane (org.eclipse.edc:control-plane-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("edc.core.controlplane");
        }

        /**
         * Returns the group of libraries at edc.core.controlplane.api
         */
        public EdcCoreControlplaneApiLibraryAccessors getApi() {
            return laccForEdcCoreControlplaneApiLibraryAccessors;
        }

    }

    public static class EdcCoreControlplaneApiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public EdcCoreControlplaneApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.eclipse.edc:control-plane-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("edc.core.controlplane.api");
        }

            /**
             * Creates a dependency provider for client (org.eclipse.edc:control-plane-api-client)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() {
                return create("edc.core.controlplane.api.client");
        }

    }

    public static class EdcCoreDpfLibraryAccessors extends SubDependencyFactory {

        public EdcCoreDpfLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for selector (org.eclipse.edc:data-plane-selector-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSelector() {
                return create("edc.core.dpf.selector");
        }

    }

    public static class EdcCorePolicyLibraryAccessors extends SubDependencyFactory {

        public EdcCorePolicyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for engine (org.eclipse.edc:policy-engine)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEngine() {
                return create("edc.core.policy.engine");
        }

    }

    public static class EdcCoreTransformLibraryAccessors extends SubDependencyFactory {

        public EdcCoreTransformLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:transform-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("edc.core.transform.core");
        }

    }

    public static class EdcExtLibraryAccessors extends SubDependencyFactory {
        private final EdcExtApiLibraryAccessors laccForEdcExtApiLibraryAccessors = new EdcExtApiLibraryAccessors(owner);
        private final EdcExtAuthLibraryAccessors laccForEdcExtAuthLibraryAccessors = new EdcExtAuthLibraryAccessors(owner);
        private final EdcExtConfigurationLibraryAccessors laccForEdcExtConfigurationLibraryAccessors = new EdcExtConfigurationLibraryAccessors(owner);
        private final EdcExtDpfLibraryAccessors laccForEdcExtDpfLibraryAccessors = new EdcExtDpfLibraryAccessors(owner);
        private final EdcExtIdentityLibraryAccessors laccForEdcExtIdentityLibraryAccessors = new EdcExtIdentityLibraryAccessors(owner);
        private final EdcExtMicrometerLibraryAccessors laccForEdcExtMicrometerLibraryAccessors = new EdcExtMicrometerLibraryAccessors(owner);
        private final EdcExtTransferLibraryAccessors laccForEdcExtTransferLibraryAccessors = new EdcExtTransferLibraryAccessors(owner);
        private final EdcExtVaultLibraryAccessors laccForEdcExtVaultLibraryAccessors = new EdcExtVaultLibraryAccessors(owner);

        public EdcExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for http (org.eclipse.edc:http)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getHttp() {
                return create("edc.ext.http");
        }

            /**
             * Creates a dependency provider for jsonld (org.eclipse.edc:json-ld)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJsonld() {
                return create("edc.ext.jsonld");
        }

        /**
         * Returns the group of libraries at edc.ext.api
         */
        public EdcExtApiLibraryAccessors getApi() {
            return laccForEdcExtApiLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext.auth
         */
        public EdcExtAuthLibraryAccessors getAuth() {
            return laccForEdcExtAuthLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext.configuration
         */
        public EdcExtConfigurationLibraryAccessors getConfiguration() {
            return laccForEdcExtConfigurationLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext.dpf
         */
        public EdcExtDpfLibraryAccessors getDpf() {
            return laccForEdcExtDpfLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext.identity
         */
        public EdcExtIdentityLibraryAccessors getIdentity() {
            return laccForEdcExtIdentityLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext.micrometer
         */
        public EdcExtMicrometerLibraryAccessors getMicrometer() {
            return laccForEdcExtMicrometerLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext.transfer
         */
        public EdcExtTransferLibraryAccessors getTransfer() {
            return laccForEdcExtTransferLibraryAccessors;
        }

        /**
         * Returns the group of libraries at edc.ext.vault
         */
        public EdcExtVaultLibraryAccessors getVault() {
            return laccForEdcExtVaultLibraryAccessors;
        }

    }

    public static class EdcExtApiLibraryAccessors extends SubDependencyFactory {
        private final EdcExtApiManagementLibraryAccessors laccForEdcExtApiManagementLibraryAccessors = new EdcExtApiManagementLibraryAccessors(owner);

        public EdcExtApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for observability (org.eclipse.edc:api-observability)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getObservability() {
                return create("edc.ext.api.observability");
        }

        /**
         * Returns the group of libraries at edc.ext.api.management
         */
        public EdcExtApiManagementLibraryAccessors getManagement() {
            return laccForEdcExtApiManagementLibraryAccessors;
        }

    }

    public static class EdcExtApiManagementLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public EdcExtApiManagementLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for management (org.eclipse.edc:management-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("edc.ext.api.management");
        }

            /**
             * Creates a dependency provider for config (org.eclipse.edc:management-api-configuration)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConfig() {
                return create("edc.ext.api.management.config");
        }

    }

    public static class EdcExtAuthLibraryAccessors extends SubDependencyFactory {

        public EdcExtAuthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for tokenbased (org.eclipse.edc:auth-tokenbased)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTokenbased() {
                return create("edc.ext.auth.tokenbased");
        }

    }

    public static class EdcExtConfigurationLibraryAccessors extends SubDependencyFactory {

        public EdcExtConfigurationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for filesystem (org.eclipse.edc:configuration-filesystem)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFilesystem() {
                return create("edc.ext.configuration.filesystem");
        }

    }

    public static class EdcExtDpfLibraryAccessors extends SubDependencyFactory {
        private final EdcExtDpfSelectorLibraryAccessors laccForEdcExtDpfSelectorLibraryAccessors = new EdcExtDpfSelectorLibraryAccessors(owner);

        public EdcExtDpfLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.eclipse.edc:data-plane-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("edc.ext.dpf.api");
        }

            /**
             * Creates a dependency provider for client (org.eclipse.edc:data-plane-client)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() {
                return create("edc.ext.dpf.client");
        }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:data-plane-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("edc.ext.dpf.core");
        }

            /**
             * Creates a dependency provider for http (org.eclipse.edc:data-plane-http)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getHttp() {
                return create("edc.ext.dpf.http");
        }

        /**
         * Returns the group of libraries at edc.ext.dpf.selector
         */
        public EdcExtDpfSelectorLibraryAccessors getSelector() {
            return laccForEdcExtDpfSelectorLibraryAccessors;
        }

    }

    public static class EdcExtDpfSelectorLibraryAccessors extends SubDependencyFactory {

        public EdcExtDpfSelectorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.eclipse.edc:data-plane-selector-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("edc.ext.dpf.selector.api");
        }

            /**
             * Creates a dependency provider for client (org.eclipse.edc:data-plane-selector-client)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() {
                return create("edc.ext.dpf.selector.client");
        }

    }

    public static class EdcExtIdentityLibraryAccessors extends SubDependencyFactory {
        private final EdcExtIdentityDidLibraryAccessors laccForEdcExtIdentityDidLibraryAccessors = new EdcExtIdentityDidLibraryAccessors(owner);

        public EdcExtIdentityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at edc.ext.identity.did
         */
        public EdcExtIdentityDidLibraryAccessors getDid() {
            return laccForEdcExtIdentityDidLibraryAccessors;
        }

    }

    public static class EdcExtIdentityDidLibraryAccessors extends SubDependencyFactory {

        public EdcExtIdentityDidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:identity-did-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("edc.ext.identity.did.core");
        }

            /**
             * Creates a dependency provider for service (org.eclipse.edc:identity-did-service)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getService() {
                return create("edc.ext.identity.did.service");
        }

            /**
             * Creates a dependency provider for web (org.eclipse.edc:identity-did-web)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWeb() {
                return create("edc.ext.identity.did.web");
        }

    }

    public static class EdcExtMicrometerLibraryAccessors extends SubDependencyFactory {

        public EdcExtMicrometerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jersey (org.eclipse.edc:jersey-micrometer)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJersey() {
                return create("edc.ext.micrometer.jersey");
        }

            /**
             * Creates a dependency provider for jetty (org.eclipse.edc:jetty-micrometer)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJetty() {
                return create("edc.ext.micrometer.jetty");
        }

    }

    public static class EdcExtTransferLibraryAccessors extends SubDependencyFactory {

        public EdcExtTransferLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for dpf (org.eclipse.edc:transfer-data-plane)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDpf() {
                return create("edc.ext.transfer.dpf");
        }

    }

    public static class EdcExtVaultLibraryAccessors extends SubDependencyFactory {

        public EdcExtVaultLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for filesystem (org.eclipse.edc:vault-filesystem)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFilesystem() {
                return create("edc.ext.vault.filesystem");
        }

    }

    public static class EdcProtocolLibraryAccessors extends SubDependencyFactory {

        public EdcProtocolLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for dsp (org.eclipse.edc:dsp)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDsp() {
                return create("edc.protocol.dsp");
        }

    }

    public static class EdcSpiLibraryAccessors extends SubDependencyFactory {
        private final EdcSpiPolicyLibraryAccessors laccForEdcSpiPolicyLibraryAccessors = new EdcSpiPolicyLibraryAccessors(owner);

        public EdcSpiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for contract (org.eclipse.edc:contract-spi)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getContract() {
                return create("edc.spi.contract");
        }

            /**
             * Creates a dependency provider for jsonld (org.eclipse.edc:json-ld-spi)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJsonld() {
                return create("edc.spi.jsonld");
        }

        /**
         * Returns the group of libraries at edc.spi.policy
         */
        public EdcSpiPolicyLibraryAccessors getPolicy() {
            return laccForEdcSpiPolicyLibraryAccessors;
        }

    }

    public static class EdcSpiPolicyLibraryAccessors extends SubDependencyFactory {

        public EdcSpiPolicyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for engine (org.eclipse.edc:policy-engine-spi)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEngine() {
                return create("edc.spi.policy.engine");
        }

    }

    public static class FcLibraryAccessors extends SubDependencyFactory {
        private final FcExtLibraryAccessors laccForFcExtLibraryAccessors = new FcExtLibraryAccessors(owner);
        private final FcSpiLibraryAccessors laccForFcSpiLibraryAccessors = new FcSpiLibraryAccessors(owner);

        public FcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:federated-catalog-core)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("fc.core");
        }

        /**
         * Returns the group of libraries at fc.ext
         */
        public FcExtLibraryAccessors getExt() {
            return laccForFcExtLibraryAccessors;
        }

        /**
         * Returns the group of libraries at fc.spi
         */
        public FcSpiLibraryAccessors getSpi() {
            return laccForFcSpiLibraryAccessors;
        }

    }

    public static class FcExtLibraryAccessors extends SubDependencyFactory {

        public FcExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.eclipse.edc:federated-catalog-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("fc.ext.api");
        }

    }

    public static class FcSpiLibraryAccessors extends SubDependencyFactory {

        public FcSpiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:federated-catalog-spi)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("fc.spi.core");
        }

    }

    public static class GatlingLibraryAccessors extends SubDependencyFactory {

        public GatlingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for highcharts (io.gatling.highcharts:gatling-charts-highcharts)
         * with versionRef 'gatling'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getHighcharts() {
                return create("gatling.highcharts");
        }

    }

    public static class IhLibraryAccessors extends SubDependencyFactory {
        private final IhCoreLibraryAccessors laccForIhCoreLibraryAccessors = new IhCoreLibraryAccessors(owner);
        private final IhExtLibraryAccessors laccForIhExtLibraryAccessors = new IhExtLibraryAccessors(owner);
        private final IhSpiLibraryAccessors laccForIhSpiLibraryAccessors = new IhSpiLibraryAccessors(owner);

        public IhLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ih.core
         */
        public IhCoreLibraryAccessors getCore() {
            return laccForIhCoreLibraryAccessors;
        }

        /**
         * Returns the group of libraries at ih.ext
         */
        public IhExtLibraryAccessors getExt() {
            return laccForIhExtLibraryAccessors;
        }

        /**
         * Returns the group of libraries at ih.spi
         */
        public IhSpiLibraryAccessors getSpi() {
            return laccForIhSpiLibraryAccessors;
        }

    }

    public static class IhCoreLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public IhCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:identity-hub)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("ih.core");
        }

            /**
             * Creates a dependency provider for client (org.eclipse.edc:identity-hub-client)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() {
                return create("ih.core.client");
        }

            /**
             * Creates a dependency provider for verifier (org.eclipse.edc:identity-hub-credentials-verifier)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getVerifier() {
                return create("ih.core.verifier");
        }

    }

    public static class IhExtLibraryAccessors extends SubDependencyFactory {
        private final IhExtApiLibraryAccessors laccForIhExtApiLibraryAccessors = new IhExtApiLibraryAccessors(owner);
        private final IhExtCredentialsLibraryAccessors laccForIhExtCredentialsLibraryAccessors = new IhExtCredentialsLibraryAccessors(owner);
        private final IhExtVerifierLibraryAccessors laccForIhExtVerifierLibraryAccessors = new IhExtVerifierLibraryAccessors(owner);

        public IhExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ih.ext.api
         */
        public IhExtApiLibraryAccessors getApi() {
            return laccForIhExtApiLibraryAccessors;
        }

        /**
         * Returns the group of libraries at ih.ext.credentials
         */
        public IhExtCredentialsLibraryAccessors getCredentials() {
            return laccForIhExtCredentialsLibraryAccessors;
        }

        /**
         * Returns the group of libraries at ih.ext.verifier
         */
        public IhExtVerifierLibraryAccessors getVerifier() {
            return laccForIhExtVerifierLibraryAccessors;
        }

    }

    public static class IhExtApiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public IhExtApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.eclipse.edc:identity-hub-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("ih.ext.api");
        }

            /**
             * Creates a dependency provider for selfdescription (org.eclipse.edc:self-description-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSelfdescription() {
                return create("ih.ext.api.selfdescription");
        }

    }

    public static class IhExtCredentialsLibraryAccessors extends SubDependencyFactory {

        public IhExtCredentialsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jwt (org.eclipse.edc:identity-hub-credentials-jwt)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJwt() {
                return create("ih.ext.credentials.jwt");
        }

    }

    public static class IhExtVerifierLibraryAccessors extends SubDependencyFactory {

        public IhExtVerifierLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jwt (org.eclipse.edc:identity-hub-verifier-jwt)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJwt() {
                return create("ih.ext.verifier.jwt");
        }

    }

    public static class IhSpiLibraryAccessors extends SubDependencyFactory {

        public IhSpiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:identity-hub-spi)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("ih.spi.core");
        }

    }

    public static class RsLibraryAccessors extends SubDependencyFactory {
        private final RsCoreLibraryAccessors laccForRsCoreLibraryAccessors = new RsCoreLibraryAccessors(owner);
        private final RsExtLibraryAccessors laccForRsExtLibraryAccessors = new RsExtLibraryAccessors(owner);
        private final RsSpiLibraryAccessors laccForRsSpiLibraryAccessors = new RsSpiLibraryAccessors(owner);

        public RsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at rs.core
         */
        public RsCoreLibraryAccessors getCore() {
            return laccForRsCoreLibraryAccessors;
        }

        /**
         * Returns the group of libraries at rs.ext
         */
        public RsExtLibraryAccessors getExt() {
            return laccForRsExtLibraryAccessors;
        }

        /**
         * Returns the group of libraries at rs.spi
         */
        public RsSpiLibraryAccessors getSpi() {
            return laccForRsSpiLibraryAccessors;
        }

    }

    public static class RsCoreLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final RsCoreCredentialLibraryAccessors laccForRsCoreCredentialLibraryAccessors = new RsCoreCredentialLibraryAccessors(owner);

        public RsCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:registration-service)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("rs.core");
        }

            /**
             * Creates a dependency provider for client (org.eclipse.edc:registration-service-client)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() {
                return create("rs.core.client");
        }

        /**
         * Returns the group of libraries at rs.core.credential
         */
        public RsCoreCredentialLibraryAccessors getCredential() {
            return laccForRsCoreCredentialLibraryAccessors;
        }

    }

    public static class RsCoreCredentialLibraryAccessors extends SubDependencyFactory {

        public RsCoreCredentialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for service (org.eclipse.edc:registration-service-credential-service)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getService() {
                return create("rs.core.credential.service");
        }

    }

    public static class RsExtLibraryAccessors extends SubDependencyFactory {

        public RsExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.eclipse.edc:registration-service-api)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("rs.ext.api");
        }

    }

    public static class RsSpiLibraryAccessors extends SubDependencyFactory {

        public RsSpiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.eclipse.edc:registration-service-spi)
         * with versionRef 'edc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("rs.spi.core");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: apacheCommons (3.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApacheCommons() { return getVersion("apacheCommons"); }

            /**
             * Returns the version associated to this alias: assertj (3.25.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAssertj() { return getVersion("assertj"); }

            /**
             * Returns the version associated to this alias: awaitility (4.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAwaitility() { return getVersion("awaitility"); }

            /**
             * Returns the version associated to this alias: edc (0.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEdc() { return getVersion("edc"); }

            /**
             * Returns the version associated to this alias: gatling (3.10.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGatling() { return getVersion("gatling"); }

            /**
             * Returns the version associated to this alias: okhttp (4.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOkhttp() { return getVersion("okhttp"); }

            /**
             * Returns the version associated to this alias: restAssured (5.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRestAssured() { return getVersion("restAssured"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final TransferBundleAccessors baccForTransferBundleAccessors = new TransferBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for connector which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.eclipse.edc:boot</li>
             *    <li>org.eclipse.edc:connector-core</li>
             *    <li>org.eclipse.edc:jersey-core</li>
             *    <li>org.eclipse.edc:api-observability</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getConnector() {
                return createBundle("connector");
            }

            /**
             * Creates a dependency bundle provider for dpf which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.eclipse.edc:data-plane-api</li>
             *    <li>org.eclipse.edc:data-plane-http</li>
             *    <li>org.eclipse.edc:data-plane-core</li>
             *    <li>org.eclipse.edc:data-plane-azure-storage</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getDpf() {
                return createBundle("dpf");
            }

            /**
             * Creates a dependency bundle provider for identity which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.eclipse.edc:identity-did-core</li>
             *    <li>org.eclipse.edc:identity-did-service</li>
             *    <li>org.eclipse.edc:identity-did-web</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getIdentity() {
                return createBundle("identity");
            }

        /**
         * Returns the group of bundles at bundles.transfer
         */
        public TransferBundleAccessors getTransfer() {
            return baccForTransferBundleAccessors;
        }

    }

    public static class TransferBundleAccessors extends BundleFactory {

        public TransferBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for transfer.dpf which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.eclipse.edc:transfer-data-plane</li>
             *    <li>org.eclipse.edc:data-plane-client</li>
             *    <li>org.eclipse.edc:data-plane-selector-client</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getDpf() {
                return createBundle("transfer.dpf");
            }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for shadow to the plugin id 'com.github.johnrengelman.shadow'
             * with version '8.1.1'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getShadow() { return createPlugin("shadow"); }

    }

}
