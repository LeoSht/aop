/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamnative.pulsar.handlers.amqp.frame.connection;

import io.netty.buffer.ByteBuf;
import io.streamnative.pulsar.handlers.amqp.frame.types.FieldTable;
import io.streamnative.pulsar.handlers.amqp.frame.types.LongString;
import io.streamnative.pulsar.handlers.amqp.frame.types.Octet;
import io.streamnative.pulsar.handlers.amqp.frame.types.UnsignedShort;
import lombok.Getter;

/**
 * This method starts the connection negotiation process by telling
 * the client the protocol version that the server proposes, along
 * with a list of security mechanisms which the client can use for
 * authentication.
 */
@Getter
public final class ConnectionStart extends Connection {

    public static final UnsignedShort METHOD_ID = new UnsignedShort(10);
    protected static final String METHOD_NAME = "start";

    private Octet versionMajor;
    private Octet versionMinor;
    private FieldTable serverProperties;
    private LongString mechanisms;
    private LongString locales;

    public ConnectionStart(ByteBuf channelBuffer) {
        this(new Octet(channelBuffer),
                new Octet(channelBuffer),
                new FieldTable(channelBuffer),
                new LongString(channelBuffer),
                new LongString(channelBuffer));
    }

    public ConnectionStart(Octet versionMajor,
                           Octet versionMinor,
                           FieldTable serverProperties,
                           LongString mechanisms,
                           LongString locales) {
        this.versionMajor = versionMajor;
        this.versionMinor = versionMinor;
        this.serverProperties = serverProperties;
        this.mechanisms = mechanisms;
        this.locales = locales;
    }

    public UnsignedShort getMethodMethodId() {
        return METHOD_ID;
    }

    @Override
    protected String getMethodMethodName() {
        return METHOD_NAME;
    }
}
