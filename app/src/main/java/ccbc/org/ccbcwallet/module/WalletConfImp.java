package ccbc.org.ccbcwallet.module;

import android.content.SharedPreferences;

import org.ccbcj.core.Context;
import org.ccbcj.core.NetworkParameters;

import global.WalletConfiguration;
import ccbc.org.ccbcwallet.utils.Configurations;

import static ccbc.org.ccbcwallet.module.CcbcContext.CONTEXT;
import static ccbc.org.ccbcwallet.module.CcbcContext.Files.BLOCKCHAIN_FILENAME;
import static ccbc.org.ccbcwallet.module.CcbcContext.Files.CHECKPOINTS_FILENAME;
import static ccbc.org.ccbcwallet.module.CcbcContext.Files.WALLET_FILENAME_PROTOBUF;
import static ccbc.org.ccbcwallet.module.CcbcContext.Files.WALLET_KEY_BACKUP_PROTOBUF;
import static ccbc.org.ccbcwallet.module.CcbcContext.NETWORK_PARAMETERS;
import static ccbc.org.ccbcwallet.module.CcbcContext.PEER_DISCOVERY_TIMEOUT_MS;
import static ccbc.org.ccbcwallet.module.CcbcContext.PEER_TIMEOUT_MS;

/**
 * Created by furszy on 6/4/17.
 */

public class WalletConfImp extends Configurations implements WalletConfiguration {

    private static final String PREF_TRUSTED_NODE = "trusted_node";
    private static final String PREFS_KEY_SCHEDULE_BLOCKCHAIN_SERVICE = "sch_block_serv";
    private static final String PREF_CURRENCY_RATE = "currency_code";


    public WalletConfImp(SharedPreferences prefs) {
        super(prefs);
    }

    @Override
    public String getTrustedNodeHost() {
        return getString(PREF_TRUSTED_NODE,null);
    }

    @Override
    public void saveTrustedNode(String host, int port) {
        save(PREF_TRUSTED_NODE,host);
    }

    @Override
    public void saveScheduleBlockchainService(long time){
        save(PREFS_KEY_SCHEDULE_BLOCKCHAIN_SERVICE,time);
    }

    @Override
    public long getScheduledBLockchainService(){
        return getLong(PREFS_KEY_SCHEDULE_BLOCKCHAIN_SERVICE,0);
    }

    @Override
    public int getTrustedNodePort() {
        return CcbcContext.NETWORK_PARAMETERS.getPort();
    }

    @Override
    public String getMnemonicFilename() {
        return CcbcContext.Files.BIP39_WORDLIST_FILENAME;
    }

    @Override
    public String getWalletProtobufFilename() {
        return WALLET_FILENAME_PROTOBUF;
    }

    @Override
    public NetworkParameters getNetworkParams() {
        return CcbcContext.NETWORK_PARAMETERS;
    }

    @Override
    public String getKeyBackupProtobuf() {
        return WALLET_KEY_BACKUP_PROTOBUF;
    }

    @Override
    public long getWalletAutosaveDelayMs() {
        return CcbcContext.Files.WALLET_AUTOSAVE_DELAY_MS;
    }

    @Override
    public Context getWalletContext() {
        return CONTEXT;
    }

    @Override
    public String getBlockchainFilename() {
        return BLOCKCHAIN_FILENAME;
    }

    @Override
    public String getCheckpointFilename() {
        return CHECKPOINTS_FILENAME;
    }

    @Override
    public int getPeerTimeoutMs() {
        return PEER_TIMEOUT_MS;
    }

    @Override
    public long getPeerDiscoveryTimeoutMs() {
        return PEER_DISCOVERY_TIMEOUT_MS;
    }

    @Override
    public int getMinMemoryNeeded() {
        return CcbcContext.MEMORY_CLASS_LOWEND;
    }

    @Override
    public long getBackupMaxChars() {
        return CcbcContext.BACKUP_MAX_CHARS;
    }

    @Override
    public boolean isTest() {
        return CcbcContext.IS_TEST;
    }

    @Override
    public int getProtocolVersion() {
        return NETWORK_PARAMETERS.getProtocolVersionNum(NetworkParameters.ProtocolVersion.CURRENT);
    }

}
