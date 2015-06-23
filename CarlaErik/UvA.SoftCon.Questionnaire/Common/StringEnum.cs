using System;
using System.Reflection;

namespace UvA.SoftCon.Questionnaire.Common
{
    /// <summary>
    /// Provides support for string enumerations.
    /// </summary>
    public static class StringEnum
    {
        /// <summary>
        /// Returns the string value of the provided enumeration field.
        /// </summary>
        /// <param name="enumValue">The enumeration value.</param>
        /// <returns>The string value of the enumeration field.</returns>
        /// <exception cref="System.ArgumentNullException">When <paramref name="enumValue"/> is null.</exception>
        /// <exception cref="System.ArgumentException">When <paramref name="enumValue"/> is not an enumeration value.</exception>
        public static string GetStringValue(object enumValue)
        {
            if (enumValue == null) { throw new ArgumentNullException("enumValue"); }

            Type enumValueType = enumValue.GetType();

            if (enumValueType.IsEnum)
            {
                FieldInfo fi = enumValueType.GetField(enumValue.ToString());
                StringValueAttribute[] attributes = (StringValueAttribute[])fi.GetCustomAttributes(typeof(StringValueAttribute), false);

                if (attributes.Length > 0)
                {
                    return attributes[0].Value;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                throw new ArgumentException("Parameter enumValue must be an enumeration value.");
            }
        }

        /// <summary>
        /// Returns the enumeration value matching the provided string value.
        /// </summary>
        /// <typeparam name="T">The enumeration type.</typeparam>
        /// <param name="value">The string value.</param>
        /// <returns>The enumeration value.</returns>
        /// <exception cref="System.ArgumentNullException">When <paramref name="value"/> is null.</exception>
        /// <exception cref="System.ArgumentException">When generic T is not an enumeration.</exception>
        public static T GetEnumerationValue<T>(string value) where T : struct
        {
            if (value == null) { throw new ArgumentNullException("value"); }

            Type enumType = typeof(T);

            if (enumType.IsEnum)
            {
                return (T)GetEnumerationValue(enumType, value);
            }
            else
            {
                throw new ArgumentException("Generic T must be an Enum type.");
            }
        }

        /// <summary>
        /// Returns the enumeration value matching the provided string value.
        /// </summary>
        /// <param name="enumType">The enumeration type.</param>
        /// <param name="value">The string value.</param>
        /// <returns>The enumeration value.</returns>
        /// <exception cref="System.ArgumentNullException">When <paramref name="enumType"/> or <paramref name="value"/> is null.</exception>
        /// <exception cref="System.ArgumentException">When <paramref name="enumType"/> does not represent an enumeration type.</exception>
        /// <exception cref="System.ArgumentException">When the value of <paramref name="value"/> does not contain a valid string value for the  enumeration type.</exception>
        public static object GetEnumerationValue(Type enumType, string value)
        {
            if (enumType == null) { throw new ArgumentNullException("enumType"); }
            if (value == null) { throw new ArgumentNullException("value"); }

            if (enumType.IsEnum)
            {
                foreach (FieldInfo fi in enumType.GetFields())
                {
                    StringValueAttribute[] attributes = (StringValueAttribute[])fi.GetCustomAttributes(typeof(StringValueAttribute), false);

                    if (attributes.Length > 0 && attributes[0].Value == value)
                    {
                        return fi.GetValue(enumType);
                    }
                }
                throw new ArgumentException("Value '" + value + "' is not a valid string value in enum type " + enumType.FullName + ".");
            }
            else
            {
                throw new ArgumentException("Supplied System.Type must be an Enum type.", "enumType");
            }
        }
    }

    /// <summary>
    /// An attribute to provide a string value on an enumeration field.
    /// </summary>
    [AttributeUsage(AttributeTargets.Field, Inherited = false, AllowMultiple = false)]
    public sealed class StringValueAttribute : System.Attribute
    {
        /// <summary>
        /// Gets the string value.
        /// </summary>
        public string Value
        {
            get;
            private set;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="UvA.SoftCon.Questionnaire.Common.StringValueAttribute"/> class.
        /// </summary>
        /// <param name="value">The string value for the enumeration field.</param>
        /// <exception cref="System.ArgumentNullException">When <paramref name="value"/> is null.</exception>
        public StringValueAttribute(string value)
        {
            if (value == null) { throw new ArgumentNullException("value"); }

            Value = value;
        }
    }
}
