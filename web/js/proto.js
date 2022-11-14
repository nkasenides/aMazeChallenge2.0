const PACKAGE = "org.inspirecenter.amazechallenge.proto";

async function loadProtoClasses() {
    protobuf.load("../proto/AMCProto.proto", function(err, root) {
        if (err)
            throw err;

        // Obtain a message type
        var HealthProto = root.lookupType(PACKAGE + ".HealthProto");

        // Exemplary payload
        var payload = { health: 50 };

        // Verify the payload if necessary (i.e. when possibly incomplete or invalid)
        var errMsg = HealthProto.verify(payload);
        if (errMsg)
            throw Error(errMsg);

        // Create a new message
        var message = HealthProto.create(payload); // or use .fromObject if conversion is necessary

        // Encode a message to an Uint8Array (browser) or Buffer (node)
        var buffer = HealthProto.encode(message).finish();
        // ... do something with buffer
        console.log(buffer);

        // Decode an Uint8Array (browser) or Buffer (node) to a message
        var message = HealthProto.decode(buffer);
        // ... do something with message

        // If the application uses length-delimited buffers, there is also encodeDelimited and decodeDelimited.

        // Maybe convert the message back to a plain object
        var object = HealthProto.toObject(message, {
            longs: String,
            enums: String,
            bytes: String,
            // see ConversionOptions
        });
        console.log(object);
    });
}