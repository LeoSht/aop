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
import io.streamnative.pulsar.handlers.amqp.frame.types.UnsignedShort;

/**
 * This method confirms a Connection.Close method and tells the
 * recipient that it is safe to release resources for the connection
 * and close the socket.
 */
public final class ConnectionCloseOk extends Connection {

    public static final UnsignedShort METHOD_ID = new UnsignedShort(61);
    protected static final String METHOD_NAME = "close-ok";


    public ConnectionCloseOk(ByteBuf channelBuffer) {
        this();
    }

    public ConnectionCloseOk() {

    }

    public UnsignedShort getMethodMethodId() {
        return METHOD_ID;
    }

    @Override
    protected String getMethodMethodName() {
        return METHOD_NAME;
    }

}
